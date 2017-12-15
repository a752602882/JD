package Module;

public class quan {


    private int id;
    private String ticket_name;
    private int type;
    private float progress;
    private Boolean is_have;
    private int limit;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicket_name() {
        return ticket_name;
    }

    public void setTicket_name(String ticket_name) {
        this.ticket_name = ticket_name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public Boolean getIs_have() {
        return is_have;
    }

    public void setIs_have(Boolean is_have) {
        this.is_have = is_have;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "id="+id+"ticket_name"+ticket_name+"type"+type+"progress"+progress+"is_have"+is_have+"limit"+limit+"price"+price;
    }
}
