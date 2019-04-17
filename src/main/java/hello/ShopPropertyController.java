package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.travelport.azure.chd.client.models.Hotel;
import com.travelport.azure.chd.client.services.HotelService;




@RestController
public class ShopPropertyController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private HotelService hotelService;

    @RequestMapping(    value= "/shop" ,
                        method = RequestMethod.GET )

    public List<Hotel> shopPropertyQuery(@RequestParam("lon") double lon,
                                         @RequestParam("lat") double lat,
                                         @RequestParam("radius") int radius) {


        List<Hotel> hotels = this.hotelService.findByLocationNear(lon, lat, radius);
        return hotels;
    }
}
