package com.tambola.service.strategy;

import com.tambola.mysql.models.Ticket;
import com.tambola.mysql.models.TicketSets;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component(value = "strategy_one")
public class StrategyOne implements TicketGenerationStartegy {
    @Override
    public List<TicketSets> generateTicket(int n) {
        List<TicketSets> ticketSets = new ArrayList<>();
        for (int i = 0; i < 6; i++) {

            int ticketArray[][] = helper();
            Ticket ticket = new Ticket();
            ticket.setTicket(ticketArray);
            TicketSets ticketSets1 = new TicketSets();
            ticketSets1.setTicket(ticket);
            ticketSets1.setSetNumber(n);
            ticketSets.add(ticketSets1);

        }
        return ticketSets;
    }


    public static int[][] helper() {
        try {
            List<List<Integer>> v = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < 9; j++) {
                    row.add(0);
                }
                v.add(row);
            }

            for (int i = 0; i < 9; i++) {
                int start = i * 9;
                int end = start + 3;
                for (int j = 0; j < 3; j++) {
                    int rdno = getRandom(start, end);
                    end += 3;
                    start += 3;
                    v.get(j).set(i, rdno);
                }
            }

            for (int i = 0; i < 3; i++) {

                while (true) {
                    Random random = new Random();
                    int col=random.nextInt(9);;
                    if (v.get(i).get(col) != 0) {
                        int countZero = 0;
                        for (int k = 0; k < 3; k++) {
                            if (v.get(k).get(col) == 0)
                                countZero++;
                        }
                        if (countZero == 2) {
                            continue;
                        }
                        int zero = 0;
                        for (int x = 0; x < 9; x++) {
                            if (v.get(i).get(x) == 0) zero++;

                        }
                        if (zero == 4) break;
                        v.get(i).set(col, 0);

                    }
                }
            }

            int response[][] = new int[3][9];

            for(int i=0;i<3;i++) {
                for(int j=0;j<9;j++) {
                    response[i][j] = v.get(i).get(j);
                }
            }
            return response;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return new int[3][9];
    }

    public static int getRandom(int start, int end) {
        Random rand = new Random();
        return rand.nextInt(end - start) + start;
    }
}
