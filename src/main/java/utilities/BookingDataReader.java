package utilities;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoclass.BookingData;

import java.io.File;
import java.util.List;

public class BookingDataReader {

    public static List<BookingData> getBookingsFromFile(String filepath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filepath), new TypeReference<List<BookingData>>() {});
    }
}
