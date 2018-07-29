package BridgePartTwo.Formats;

import BridgePartTwo.Detail;

import java.util.List;

public interface Formatter {

    String format(String header, List<Detail> details);

}
