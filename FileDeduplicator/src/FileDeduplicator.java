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
        this.directory = new File(filePath);
        Preconditions.checkState(this.directory.isDirectory(), "doesn't exist");

    }

    public Collection<FileDuplicate> calculateDuplicates() {

        final long start = System.currentTimeMillis();

        FluentIterable<FileRecord> records = Files.fileTreeTraverser()
                .breadthFirstTraversal(this.directory)
                .filter(File::isFile)
                .transform(FileRecord::new);

        final Multimap<HashCode, Path> duplicateCandidates = ArrayListMultimap.create();

        records.forEach(fileRecord -> duplicateCandidates.put(fileRecord.getHashCode(), fileRecord.getFilePath()));

        final Multimap<HashCode, Path> dupesOnly = Multimaps.filterKeys(duplicateCandidates, record -> duplicateCandidates.get(record).size() > 1);

        FluentIterable<FileDuplicate> fileDuplicates = FluentIterable.from(dupesOnly.asMap()
                .entrySet())
                .transformAndConcat((Function<Map.Entry<HashCode, Collection<Path>>, Iterable<FileDuplicate>>) input -> Collections.singleton(new FileDuplicate(input.getKey(), input.getValue())));

        System.out.println("Took: " + (System.currentTimeMillis() - start) + " ms");

        return ImmutableSet.copyOf(fileDuplicates);
    }

    public static void main(String[] args){

        final FileDeduplicator fileDeduplicator = new FileDeduplicator("C:\\Users\\Jack\\Desktop\\duptest");
        final Collection<FileDuplicate> duplicates = fileDeduplicator.calculateDuplicates();
        System.out.println(duplicates);

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
                System.out.println("file "+ file + "hashed using "+ HASH_FUNCTION + " took " + (System.currentTimeMillis() - startTime) + " ms");
                return hash;

            }catch(final IOException e){
                throw new RuntimeException(e);
            }
        }

    }


}
