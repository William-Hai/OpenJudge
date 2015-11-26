package org.poj.p3718;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main0 {

    /**
     * ȡ��һ������������ѭ�����ƺ�Ķ���������
     */
    private static int[] getCycleMoveLeftN(int[] binary, int n) {
        int[] mover = new int[n];
        // ���Ȼ��16�����������н�Ҫ���Ƴ�ȥ��nλ
        for (int i = 0; i < n; i++) {
            mover[i] = binary[i];
        }
        
        for(int i = 0, j = 0; i < binary.length; i++) {
            if (i < binary.length - n) {
                binary[i] = binary[i + n];
            }else {
                binary[i] = mover[j++];
            }
        }
        
        return binary;
    }
    
    private static int[] getReverseBinaryArray(int[] bin) {
        for (int i = 0; i < (bin.length / 2); i++) {
            bin[i] = bin[i] + bin[bin.length - 1 - i];
            bin[bin.length - 1 - i] = bin[i] - bin[bin.length - 1 - i];
            bin[i] = bin[i] - bin[bin.length - 1 - i];
        }
        
        return bin;
    }
    
    /**
     * ��һ�����͵���ת��һ��16λ�Ķ���������
     */
    private static int[] getBinaryArray(int x) {
        int[] bin = new int[16];
        
        for (int i = 0; i < bin.length; i++) {
            bin[i] = x % 2;
            x /= 2;
            if (x == 0) {
                break;
            }
        }
        bin = getReverseBinaryArray(bin);
        return bin;
    }
    
    /**
     * �ж��ǲ�����ͬ�Ķ���������
     */
    private static boolean isSameBinary(int[] binA, int[] binB) {
        for (int i = 0; i < binA.length; i++) {
            if(binA[i] != binB[i]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * �ж��Ƿ��ܹ�ת��
     */
    private static boolean canTransform(int a, int b) {
        boolean can = false;
//        for (int i = 0; i < 16; i++) {
//            a = (a << 1 | a >> 15);
//            if (a == b) {
//                can = true;
//                break;
//            }
//        }
        int[] binA = getBinaryArray(a);
        int[] binB = getBinaryArray(b);
        for (int i = 0; i < 16; i++) {
            if (isSameBinary(getCycleMoveLeftN(binA, i), binB)) {
                can = true;
                break;
            }
        }
        return can;
    }
    
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 16));
        System.out.println(Integer.MAX_VALUE);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            int n = Integer.parseInt(reader.readLine());
            while(n-- > 0) {
                String[] numbers = reader.readLine().split(" ");
                int firstNumber = Integer.parseInt(numbers[0]);
                int secondNumber = Integer.parseInt(numbers[1]);
                if (canTransform(firstNumber, secondNumber)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        } catch (Exception e) {
        }
    }
}