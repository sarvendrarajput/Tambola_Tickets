package com.tambola.mysql.models;

public class Ticket {

    private int ticket[][];

    public Ticket() {
        ticket = new int[3][9];
    }

    public Ticket(int row, int column) {
        ticket = new int[row][column];
    }

//    public void setRowColumn(int rowIdx, String val) {
//        if(rowIdx < 0 || rowIdx >= ticket.length ) {
//            return;
//        }
//        this.ticket[rowIdx] = val;
//    }
//
//    public String getByRowCol(int row) {
//        return this.ticket[row];
//    }

    public int[][] getTicket() {
        return ticket;
    }

    public void setTicket(int[][] ticket) {
        this.ticket = ticket;
    }
}
