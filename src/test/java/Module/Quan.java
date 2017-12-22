package Module;

public class Quan {


    private String ticket_name;
    private String progress;
    private String is_have;
    private String limit;
    private String price;



    public Quan(String ticket_name,String progress,String is_have,String limit,String price){

        this.ticket_name =ticket_name;
        this.progress=progress;
        this.is_have = is_have;
        this.limit = limit;
        this.price = price;
    }



    public String getTicket_name() {
        return ticket_name;
    }

    public void setTicket_name(String ticket_name) {
        this.ticket_name = ticket_name;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getIs_have() {
        return is_have;
    }

    public void setIs_have(String is_have) {
        this.is_have = is_have;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ticket_name"+ticket_name+"progress"+progress+"is_have"+is_have+"limit"+limit+"price"+price;
    }
}
