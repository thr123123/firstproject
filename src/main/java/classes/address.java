package classes;

public class address {
    String id;
    String use_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUse_id() {
        return use_id;
    }

    @Override
    public String toString() {
        return "address{" +
                "id='" + id + '\'' +
                ", use_id='" + use_id + '\'' +
                '}';
    }

    public void setUse_id(String use_id) {
        this.use_id = use_id;
    }

    public address(){}
    public address(String id,String use_id){
        this.id=id;
        this.use_id=use_id;
    }
}
