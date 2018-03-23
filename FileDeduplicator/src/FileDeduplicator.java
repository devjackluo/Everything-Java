import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.*;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class FileDeduplicator {

    final File directory;

    FileDeduplicator(final String filePath){

        //create directory and check if it exist with guava precondition.
        this.directory = new File(filePath);
        Preconditions.checkState(this.directory.isDirectory(), "doesn't exist");

    }

    public Collection<FileDuplicate> calculateDuplicates() {

        final long start = System.currentTimeMillis();

        //make list of all files in that directory.
        FluentIterable<FileRecord> records = Files.fileTreeTraverser()
                .breadthFirstTraversal(this.directory)
                .filter(File::isFile)
                .transform(FileRecord::new);

        //create blank multimap
        final Multimap<HashCode, Path> duplicateCandidates = ArrayListMultimap.create();

        //go thru all files from list and all to multimap the hashcode and the path
        //since it is a map, when hashcode is the same, it doesn't create new value, instead it adds to the key's list
        records.forEach(fileRecord -> duplicateCandidates.put(fileRecord.getHashCode(), fileRecord.getFilePath()));

        //now we only want a completed multimap with only files that have duplicates.
        final Multimap<HashCode, Path> dupesOnly = Multimaps.filterKeys(duplicateCandidates, record -> duplicateCandidates.get(record).size() > 1);

        //System.out.println(dupesOnly);

        //convert multimap of dupes to a collection of file duplicate classes.
        //not sure why we need to convert to a collection of classes but ok. object-oriented programming benefits!?
        FluentIterable<FileDuplicate> fileDuplicates = FluentIterable.from(dupesOnly.asMap()
                .entrySet())
                .transformAndConcat((Function<Map.Entry<HashCode, Collection<Path>>, Iterable<FileDuplicate>>) input -> Collections.singleton(new FileDuplicate(input.getKey(), input.getValue())));

        System.out.println("Took: " + (System.currentTimeMillis() - start) + " ms");

        //System.out.println(fileDuplicates);

        return ImmutableSet.copyOf(fileDuplicates);
    }

    static class FileDuplicate{

        final HashCode hashCode;
        final Collection<Path> paths;

        FileDuplicate(final HashCode hashCode, final Collection<Path> paths){
            this.hashCode = hashCode;
            this.paths = ImmutableList.copyOf(paths);
        }

        @Override
        public String toString(){
            return this.hashCode + "\n" + "\t" + this.paths;
        }

    }

    static class FileRecord{

        private final HashCode hashCode;
        private final Path path;

        private final static HashFunction HASH_FUNCTION = Hashing.goodFastHash(32);

        FileRecord(final File file){
            this.hashCode = hashFile(file);
            this.path = file.toPath();
        }


        public HashCode getHashCode() {
            return this.hashCode;
        }

        public Path getFilePath() {
            return this.path;
        }

        private HashCode hashFile(final File file){
            try{

                final long startTime = System.currentTimeMillis();
                final HashCode hash = Files.asByteSource(file).hash(HASH_FUNCTION);
                //System.out.println("file "+ file + "hashed using "+ HASH_FUNCTION + " took " + (System.currentTimeMillis() - startTime) + " ms");
                return hash;

            }catch(final IOException e){
                throw new RuntimeException(e);
            }
        }

    }




    public static void main(String[] args){

        //create the filedupcator and check path exist
        final FileDeduplicator fileDeduplicator = new FileDeduplicator("C:\\Users\\Jack\\Desktop\\duptest");
        //final FileDeduplicator fileDeduplicator = new FileDeduplicator("C:\\Users\\Jack\\Desktop");

        //run caldup function to retrieve list of all duplicates in that folder
        final Collection<FileDuplicate> duplicates = fileDeduplicator.calculateDuplicates();

        //print out fluent iterable.. whatever it is. i guess
        //System.out.println(duplicates);
        for(FileDuplicate fd : duplicates){
            System.out.println(fd + "\n");
        }

    }


}
