public class Book extends Media{
    private String publisher;
    public Book(){
        super();
        this.publisher = "Unknown Publisher";
    }
    public Book(String title, String creator, String publisher){
        super(title, creator);
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }
}
