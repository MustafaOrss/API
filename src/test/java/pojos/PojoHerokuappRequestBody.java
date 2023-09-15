package pojos;

public class PojoHerokuappRequestBody
{
    // 1) Tum variable’lari "private" olarak olusturalim

        private String firstname;
        private String lastname;

        private Integer totalprice;
        private Boolean depositpaid;

        private PojoHerokuappBookingdates booking;
        private String additionalneeds;


        // 2) Tum variable’lar icin getter( ) and setter( ) metodlari olusturalim

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public Integer getTotalprice() {
            return totalprice;
        }

        public void setTotalprice(Integer totalprice) {
            this.totalprice = totalprice;
        }

        public Boolean getDepositpaid() {
            return depositpaid;
        }

        public void setDepositpaid(Boolean depositpaid) {
            this.depositpaid = depositpaid;
        }

        public PojoHerokuappBookingdates getBooking() {
            return booking;
        }

        public void setBooking(PojoHerokuappBookingdates booking) {
            this.booking = booking;
        }

        public String getAdditionalneeds() {
            return additionalneeds;
        }

        public void setAdditionalneeds(String additionalneeds) {
            this.additionalneeds = additionalneeds;
        }


        // 3) Tum parametreleri iceren bir constructor olusturalim

        public PojoHerokuappRequestBody(String firstname, String lastname, Integer totalprice, Boolean depositpaid, PojoHerokuappBookingdates booking, String additionalneeds) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.totalprice = totalprice;
            this.depositpaid = depositpaid;
            this.booking = booking;
            this.additionalneeds = additionalneeds;
        }


        // 4) Default constructor (parametresiz) olusturalim

        public PojoHerokuappRequestBody() {
        }


        // 5) toString( ) metodu olusturalim


        @Override
        public String toString() {
            return "PojoHerokuappRequestBody{" +
                    "firstname='" + firstname + '\'' +
                    ", lastname='" + lastname + '\'' +
                    ", totalprice=" + totalprice +
                    ", depositpaid=" + depositpaid +
                    ", booking=" + booking +
                    ", additionalneeds='" + additionalneeds + '\'' +
                    '}';
        }
}
