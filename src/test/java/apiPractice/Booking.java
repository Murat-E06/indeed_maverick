package apiPractice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@JsonIgnoreProperties(value = "bookingdates",allowSetters = true)
public class Booking {
    private String firstname;
    private String lastname;
    private int  totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates= new BookingDates();
    private String additionalneeds;

    public void setBookingdates(String checkin,String checkout) {
        bookingdates.setCheckin(checkin);
        bookingdates.setCheckout(checkout);

    }

    @Override
    public String toString() {
        return "{\n" +
                "    \"firstname\" : \"" +getFirstname()+"\",\n"+
                "    \"lastname\" : \""+getLastname()+"\",\n" +
                "    \"totalprice\" : "+getTotalprice()+",\n" +
                "    \"depositpaid\" : "+depositpaid+",\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \""+ bookingdates.getCheckin()+"\",\n" +
                "        \"checkout\" : \""+ bookingdates.getCheckout()+"\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \""+ additionalneeds+"\"\n" +
                "}";

    }
}

