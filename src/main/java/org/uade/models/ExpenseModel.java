package org.uade.models;

public class ExpenseModel {
    private CardModel card;
    private double expense;
    private String month;
    private String year;
    private String place;

    public ExpenseModel(CardModel card, double expense, String month, String year, String place) {
        this.card = card;
        this.expense = expense;
        this.month = month;
        this.year = year;
        this.place = place;
    }

    public CardModel getCard() {
        return card;
    }

    public double getExpense() {
        return expense;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getPlace() {
        return place;
    }
}