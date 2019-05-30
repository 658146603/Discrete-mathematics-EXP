import java.util.*;

/** @author wcf
 *
 * 开发环境：
 * Windows 10 家庭版 x64, Intel i7 8750H, 8GB RAM, 128 GB SSD
 * IDE : intellij IDEA
 * JDK : OpenJDK 11.0.1
 *
 * 运行环境：
 * 推荐使用 JDK 11.0.1 环境下编译运行
 *
 * 1.void testExp_01() 离散数学 实验题1：
 * 输入 集合A HashSet<String> A
 * 输入 集合B HashSet<String> B
 * 输入 集合E HashSet<String> E
 * 输出 A, B, U, AnB, Aub, A-B, B-A, A+B, B+A, ~A, ~B
 *
 * 2.void testExp_02() 离散数学 实验题2：
 * 输入 关系矩阵大小 n
 * 输入 矩阵M
 * 输出 矩阵M
 * 输出 矩阵M对应的关系
 * 输出 M的自反闭包
 * 输出 M的对称闭包
 * 输出 M的传递闭包
 *
 * 3.void testExp_04() 离散数学 实验题4：
 * 输入 关系矩阵大小 n
 * 输入 矩阵M
 * 输出 矩阵M
 * 输出 矩阵M对应的关系
 * 输出 M是否为偏序关系
 * 输出 M的极小、极大元
 * 输出 M最小、最大元
 *
 */

public class Main {

    public static void main(String[] args) {
        //testExp_01();
        //testExp_02();
        testExp_04();
    }

    private static void testExp_04() {
        /**
         * Sample Input:
         *
         * Input Size Of Matrix :
         * 7
         * Input the Matrix :
         * 1 0 0 0 1 0 0
         * 0 1 0 0 0 1 1
         * 0 0 1 0 0 1 0
         * 0 0 0 1 1 0 1
         * 0 0 0 0 1 0 0
         * 0 0 0 0 0 1 0
         * 0 0 0 0 0 0 1
         *
         * Sample Output:
         *
         * M :
         * [1, 0, 0, 0, 1, 0, 0]
         * [0, 1, 0, 0, 0, 1, 1]
         * [0, 0, 1, 0, 0, 1, 0]
         * [0, 0, 0, 1, 1, 0, 1]
         * [0, 0, 0, 0, 1, 0, 0]
         * [0, 0, 0, 0, 0, 1, 0]
         * [0, 0, 0, 0, 0, 0, 1]
         * { <1,1>,  <1,5>,  <2,2>,  <2,6>,  <2,7>,  <3,3>,  <3,6>,  <4,4>,  <4,5>,  <4,7>,  <5,5>,  <6,6>,  <7,7>, }
         * 集合M是偏序关系
         * 1 是极小元
         * 2 是极小元
         * 3 是极小元
         * 4 是极小元
         * 5 是极大元
         * 6 是极大元
         * 7 是极大元
         * 无最小元
         * 无最大元
         */

        /**
         * scanner用于从控制台读取输入的一个数字，字符，字符串或一行文字
         */
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input Size Of Matrix : ");
        /**
         * n从键盘中输入，用于确定关系矩阵的大小
         */
        int n=scanner.nextInt();
        /**
         * 定义一个二维数组，用于保存关系矩阵，0为关系不存在，非零为关系存在
         * 下面的循环用于输入矩阵
         */
        int[][] M=new int[n][n];
        System.out.println("Input the Matrix : ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                M[i][j]=scanner.nextInt()==0?0:1;
            }
        }
        /**
         * 输出矩阵M的值
         */
        System.out.println("M : ");
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(M[i]));
        }
        System.out.print("{");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(M[i][j]!=0){
                    System.out.print(" <"+(i+1)+ ","+(j+1)+">, ");
                }
            }
        }
        System.out.println("}");

        /**
         * 验证自反性
         * 检查对角线是否都存在，如果不存在则将属性@isReverse设置为false
         */ 
        boolean isReverse=true;
        for (int i = 0; i < n; i++) {
            if(M[i][i]==0){
                isReverse=false;
                break;
            }
        }

        // if(isReverse){
        //     System.out.println("集合M具有自反性");
        // } else {
        //     System.out.println("集合M没有自反性");
        // }

        /**
         * 验证对称性，如果@M[i][j]!=0且@M[j][i]==0则判断没有对称性
         */
        boolean isSymmetrical=true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(M[i][j]!=0&&M[j][i]==0){
                    isSymmetrical=false;
                }
            }
        }

        // if(isSymmetrical){
        //     System.out.println("集合M具有对称性");
        // } else {
        //     System.out.println("集合M没有对称性");
        // }

        /**
         * 验证反对称性，如果i!=j且@M[i][j]!=0且@M[j][i]！=0则判断没有反对称性
         */
        boolean isUnSymmetrical=true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i!=j&&M[i][j]!=0&&M[j][i]!=0){
                    isUnSymmetrical=false;
                    break;
                }
            }
        }

        // if(isUnSymmetrical){
        //     System.out.println("集合M具有反对称性");
        // } else {
        //     System.out.println("集合M没有反对称性");
        // }

        /**
         * 验证传递性，对矩阵进行二次矩阵乘法并相加，最后与原矩阵进行比较，如果M不是M*M的子集，则矩阵没有传递性
         */
        boolean isTransitivity=true;
        int[][] tempM=new int[n][n];
        for (int i = 0; i < n; i++) {
            tempM[i]=M[i].clone();
        }
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                tempM[i][j] = getLineMultiply(M, M, i, j);
            }
        }
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(tempM[i][j]!=0&&M[i][j]==0){
                    isTransitivity=false;
                    break;
                }
            }
        }

        // if(isTransitivity){
        //     System.out.println("集合M具有传递性");
        // } else {
        //     System.out.println("集合M没有传递性");
        // }

        /**
         * 偏序关系满足自反性，反对称性，传递性
         */
        if (isReverse&&isUnSymmetrical&&isTransitivity){
            System.out.println("集合M是偏序关系");
            int[] in = new int[n];
            int[] out = new int[n];
            /*
             * 计算极大元，极小元
             * 通过计算每个元素的入度和出度来判断极大元和极小元，入度为1则为极小元，出度为1则为极大元
             * 如果有多个入度为1的元素，则极小元有多个，故没有最小元，否则唯一的极小元为最小元
             * 如果有多个出度为1的元素，则极大元有多个，故没有极大元，否则唯一的极大元为最大元
             */
            for(int i=0;i<n;i++){
                for (int j = 0; j < n; j++) {
                    if (M[i][j]!=0){
                        out[i]++;
                    }
                    if (M[j][i]!=0){
                        in[i]++;
                    }
                }

            }

//            System.out.println("in "+ Arrays.toString(in));
//            System.out.println("out "+ Arrays.toString(out));

            int numIn=0;
            int numOut=0;
            int tMax = 0,tMin = 0;

            for (int i = 0; i < n; i++) {
                if(in[i]==1){
                    System.out.println((i+1)+" 是极小元");
                    tMin=i+1;
                    numIn++;
                }
                if (out[i]==1){
                    System.out.println((i+1)+" 是极大元");
                    tMax=i+1;
                    numOut++;
                }
            }

            if(numIn==1){
                System.out.println("最小元是 "+tMin);
            } else {
                System.out.println("无最小元");
            }
            if(numOut==1){
                System.out.println("最大元是 "+tMax);
            } else {
                System.out.println("无最大元");
            }
        } else {
            System.out.println("集合M不是偏序关系");
        }


    }

    private static void testExp_01() {
        /**
         * Sample Input
         *
         * Input SET A :
         * 1 2 3 4
         * Input SET B :
         * 2 3 4 5
         * Input SET U :
         * 1 2 3 4 5
         *
         * Sample Output
         * SET A: [1, 2, 3, 4]
         * SET B: [2, 3, 4, 5]
         * SET U: [1, 2, 3, 4, 5]
         * AuB : [1, 2, 3, 4, 5]
         * AnB : [2, 3, 4]
         * A-B : [1]
         * B-A : [5]
         * A+B : [1, 5]
         * B+A : [1, 5]
         * ~A : [5]
         * ~B : [1]
         */
        Scanner scanner=new Scanner(System.in);
        HashSet<String> A,B,E;
        System.out.println("Input SET A : ");
        List<String> listA=Arrays.asList(scanner.nextLine().split(" "));
        System.out.println("Input SET B : ");
        List<String> listB=Arrays.asList(scanner.nextLine().split(" "));
        System.out.println("Input SET E : ");
        List<String> listE=Arrays.asList(scanner.nextLine().split(" "));
        A=new HashSet<>(listA);
        B=new HashSet<>(listB);
        E=new HashSet<>(listE);
        System.out.print("SET A: ");
        System.out.println(A);
        System.out.print("SET B: ");
        System.out.println(B);
        for(String i: A){
            if(!E.contains(i)){
                System.out.println("E 没有包含A 或 B！");
                return;
            }
        }

        for(String i: B){
            if(!E.contains(i)){
                System.out.println("E 没有包含A 或 B！");
                return;
            }
        }

        System.out.print("SET E: ");
        System.out.println(E);

        // 并集
        HashSet<String> AuB=new HashSet<>();
        AuB.addAll(A);
        AuB.addAll(B);
        System.out.print("AuB : ");
        System.out.println(AuB);

        // 交集
        HashSet<String> AnB=new HashSet<>();
        for(String i: A){
            if(B.contains(i)){
                AnB.add(i);
            }
        }
        System.out.print("AnB : ");
        System.out.println(AnB);

        // A-B
        HashSet<String> ANotB=new HashSet<>();
        for(String i: A){
            if(!B.contains(i)){
                ANotB.add(i);
            }
        }
        System.out.print("A-B : ");
        System.out.println(ANotB);

        // B-A
        HashSet<String> BNotA=new HashSet<>();
        for(String i: B){
            if(!A.contains(i)){
                BNotA.add(i);
            }
        }
        System.out.print("B-A : ");
        System.out.println(BNotA);

        // A+B
        HashSet<String> AuBNotAnB=new HashSet<>(AuB);
        for(String i: AnB){
            if(AuB.contains(i)){
                AuBNotAnB.remove(i);
            }
        }
        /*
         * another method:
         * AuBNotAnB.addAll(ANotB);
         * AuBNotAnB.addAll(BNotA);
         */
        System.out.print("A+B : ");
        System.out.println(AuBNotAnB);

        // B+A
        System.out.print("B+A : ");
        System.out.println(AuBNotAnB);

        // ~A
        HashSet<String> UNotA=new HashSet<>();
        for(String i: E){
            if(!A.contains(i)){
                UNotA.add(i);
            }
        }
        System.out.print("~A : ");
        System.out.println(UNotA);

        //~B
        HashSet<String> UNotB=new HashSet<>();
        for(String i: E){
            if(!B.contains(i)){
                UNotB.add(i);
            }
        }
        System.out.print("~B : ");
        System.out.println(UNotB);
    }

    private static void testExp_02() {
        /**
         * Sample Input:
         *
         * Input Size Of Matrix :
         * 6
         * Input the Matrix :
         * 1 1 1 1 1 1
         * 0 1 0 1 1 1
         * 0 0 1 0 0 0
         * 0 0 0 1 0 1
         * 0 0 0 0 1 0
         * 0 0 0 0 0 1
         *
         * Sample Output:
         *
         * M :
         * [1, 1, 1, 1, 1, 1]
         * [0, 1, 0, 1, 1, 1]
         * [0, 0, 1, 0, 0, 0]
         * [0, 0, 0, 1, 0, 1]
         * [0, 0, 0, 0, 1, 0]
         * [0, 0, 0, 0, 0, 1]
         * { <1,1>,  <1,2>,  <1,3>,  <1,4>,  <1,5>,  <1,6>,  <2,2>,  <2,4>,  <2,5>,  <2,6>,  <3,3>,  <4,4>,  <4,6>,  <5,5>,  <6,6>, }
         * M 自反闭包 rM : { <1,1>,  <1,2>,  <1,3>,  <1,4>,  <1,5>,  <1,6>,  <2,2>,  <2,4>,  <2,5>,  <2,6>,  <3,3>,  <4,4>,  <4,6>,  <5,5>,  <6,6>, }
         * M 对称闭包 sM : { <1,1>,  <1,2>,  <1,3>,  <1,4>,  <1,5>,  <1,6>,  <2,1>,  <2,2>,  <2,4>,  <2,5>,  <2,6>,  <3,1>,  <3,3>,  <4,1>,  <4,2>,  <4,4>,  <4,6>,  <5,1>,  <5,2>,  <5,5>,  <6,1>,  <6,2>,  <6,4>,  <6,6>, }
         * M 传递闭包 tM : { <1,1>,  <1,2>,  <1,3>,  <1,4>,  <1,5>,  <1,6>,  <2,2>,  <2,4>,  <2,5>,  <2,6>,  <3,3>,  <4,4>,  <4,6>,  <5,5>,  <6,6>, }
         *
         */
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input Size Of Matrix : ");
        int n=scanner.nextInt();
        int[][] M=new int[n][n];
        System.out.println("Input the Matrix : ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                M[i][j]=scanner.nextInt()==0?0:1;
            }
        }
        System.out.println("M : ");
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(M[i]));
        }
        System.out.print("{");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(M[i][j]!=0){
                    System.out.print(" <"+(i+1)+ ","+(j+1)+">, ");
                }
            }
        }
        System.out.println("}");

        // 自反闭包
        int[][] rM=new int[n][n];
        for(int i=0;i<n;i++){
            rM[i][i]=1;
            for(int j=0;j<n;j++){
                if(M[i][j]!=0){
                    rM[i][j]=1;
                }
            }
        }
        System.out.print("M 自反闭包 rM : {");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(rM[i][j]!=0){
                    System.out.print(" <"+(i+1)+ ","+(j+1)+">, ");
                }
            }
        }
        System.out.println("}");


        // 对称闭包
        int[][] sM=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(M[i][j]!=0){
                    sM[i][j]=1;
                    sM[j][i]=1;
                }
            }
        }
        System.out.print("M 对称闭包 sM : {");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(sM[i][j]!=0){
                    System.out.print(" <"+(i+1)+ ","+(j+1)+">, ");
                }
            }
        }
        System.out.println("}");

        // 传递闭包
        int[][] tM=new int[n][n];
        for (int i = 0; i < n; i++) {
            tM[i]=M[i].clone();
        }
        for(int u=0;u<n;u++){
            // u+1次矩阵
            for(int t=0;t<u;t++){
                int[][] tempM=new int[n][n];
                for (int i = 0; i < n; i++) {
                    tempM[i]=M[i].clone();
                }
                for(int i=0;i<n;i++){
                    for (int j=0;j<n;j++){
                        tM[i][j] = tM[i][j] + getLineMultiply(tempM, M, i, j);
                    }
                }
            }
        }

        System.out.print("M 传递闭包 tM : {");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(tM[i][j]!=0){
                    System.out.print(" <"+(i+1)+ ","+(j+1)+">, ");
                }
            }
        }
        System.out.println("}");

    }

    private static int getLineMultiply(int[][] a, int[][] b, int i, int j){
        int t=0;
        for(int k=0;k<a.length;k++){
            t+=a[i][k]*b[k][j];
        }
        return t==0?0:1;
    }
}
