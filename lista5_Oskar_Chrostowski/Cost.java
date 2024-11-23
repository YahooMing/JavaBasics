import java.time.LocalDate;

public class Cost {
    private final CostType type;
    private final LocalDate date;
    private final int amount;
    public Cost(CostType type, LocalDate date, int amount){
        this.type = type;
        this.date = date;
        this.amount = amount;
    }

    public CostType getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }
    public String toString(){
        return "type=" + type.toString() + ", date=" + date.toString() + ", amount=" + amount;
    }
}