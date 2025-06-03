package models.classes.Expense;

public class Expense {
    Card card;
    int expense;
    String month;
    String year;
    String place;

    public Expense(Card card, int expense, String month, String year, String place) {
        this.card = card;
        this.expense = expense;
        this.month = month;
        this.year = year;
        this.place = place;
    }
}