import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunLengthEncoder {

    public String encode(final String source){

        final StringBuilder builder = new StringBuilder();

        for(int i = 0; i < source.length(); i++){
            int runLength = 1;
            while(i+1 < source.length() && source.charAt(i) == source.charAt(i+1)){
                runLength++;
                i++;
            }

            builder.append(runLength);
            builder.append(source.charAt(i));

        }

        return builder.toString();
    }

    public String decode(final String encodedStr){

        final StringBuilder builder = new StringBuilder();
        final Pattern pattern = Pattern.compile("([\\d]+)([^\\d]+)");
        final Matcher matcher = pattern.matcher(encodedStr);
        while(matcher.find()){
            builder.append(String.join("", Collections.nCopies(Integer.parseInt(matcher.group(1)), matcher.group(2))));
        }

        return builder.toString();
    }


}
