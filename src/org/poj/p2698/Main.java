package org.poj.p2698;

/**
 * ������
 */
public class Main {

    private int[] column; // ͬ���Ƿ��лʺ�1��ʾ��
    private int[] rup; // �����������Ƿ��лʺ�
    private int[] lup; // �����������Ƿ��лʺ�
    private int[] queen; // ���
    private int num; // �����

    public Main() {
        column = new int[8 + 1];
        rup = new int[(2 * 8) + 1];
        lup = new int[(2 * 8) + 1];

        for (int i = 1; i <= 8; i++) {
            column[i] = 1;
        }

        for (int i = 1; i <= (2 * 8); i++) {
            rup[i] = 1;
            lup[i] = 1;
        }

        queen = new int[8 + 1];
    }

    public void backtrack(int raw) {
        if (raw > 8) {
            showAnswer();
        } else {
            for (int c = 1; c <= 8; c++) {
                if ((column[c] == 1) && (rup[raw + c] == 1) && (lup[raw - c + 8] == 1)) {
                    queen[raw] = c;
                    // �趨Ϊռ��
                    column[c] = rup[raw + c] = lup[raw - c + 8] = 0;
                    backtrack(raw + 1);
                    column[c] = rup[raw + c] = lup[raw - c + 8] = 1;
                }
            }
        }
    }

    protected void showAnswer() {
        num++;
        System.out.println("No. " + num);

        for (int x = 1; x <= 8; x++) {
            for (int y = 1; y <= 8; y++) {
                String suffix = "";
                if (y < 8) {
                    suffix = " ";
                }
                if (queen[y] == x) {
                    System.out.print("1" + suffix);
                } else {
                    System.out.print("0" + suffix);
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main queen = new Main();
        queen.backtrack(1);
    }
}