package com.tambola.mysql.models;

public class TicketTemporary {

    private int ticket[][];

    public TicketTemporary() {
        ticket = new int[3][9];
    }

    public TicketTemporary(int row, int column) {
        ticket = new int[row][column];
    }

    public void setRowColumn(int rowIdx, int columnIdx, int val) {
        if(rowIdx < 0 || rowIdx >= ticket.length || columnIdx < 0 || columnIdx >= ticket[0].length) {
            return;
        }
        this.ticket[rowIdx][columnIdx] = val;
    }

    public int getByRowCol(int row, int col) {
        return this.ticket[row][col];
    }

    public int[][] getTicket() {
        return ticket;
    }

    public void setTicket(int[][] ticket) {
        this.ticket = ticket;
    }
}
