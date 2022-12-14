package JianZhiOfferCoding;

public class A43_CountDigitOne {
    public static void main(String[] args) {

    }
//    case 1: cur=0
//      2  3   0  4
//      千位和百位可以选00 01 02....22  十位可以取到1( 形如[00|01..|22]1[0-9] 都是<2304 ) 个位可以选0-9  共有 23 * 10 中排列
//      当千位和百位取23,如果十位取1 那就是形如 231[0-9] > 2304,所以当千位和百位取23，十位只能能取0，个位取0-4即 2300 2301 2302 2303 2304
//      但是2301不应该算进来，这个1是 单独  出现在个位的（而11，121,111这种可以被算多次）
//      即 23*10
//    case 2: cur=1
//      2  3  1  4
//      千位和百位可以选00 01 02....22  十位可以取到1 个位可以选0-9  共有 23 * 10 中排列
//      当千位和百位取23,十位取1，个位可以去0-4 即 2310-2314共5个
//      即 23 *10 + 4 +1
//    case 3: cur>1 即2-9
//      2  3  2  4
//      千位和百位可以选00 01 02....22  十位可以取到1(形如 [00|01...|22]1[0-9] 都是<2324) 个位可以选0-9  共有 23 * 10 中排列
//      当千位和百位取23,十位取1，个位可以去0-9 即 2310-2319共10个 （其中2311，被计算了两次，分别是从个位和十位分析得到的1次）
//      即 23 *10 + 10

    public int countDigitOne(int n) {
        int res = 0;
        int digit = 1;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            }else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += high * digit + digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

}


