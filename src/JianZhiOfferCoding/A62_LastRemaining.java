package JianZhiOfferCoding;

public class A62_LastRemaining {
    public static void main(String[] args) {
        A62_LastRemaining so = new A62_LastRemaining();
        int i = so.lastRemaining(5, 3);
        System.out.println(i);
        System.out.println(so);
    }

//    最后只剩下一个元素，假设这个最后存活的元素为 num, 这个元素最终的的下标一定是0 （因为最后只剩这一个元素），
//    所以如果我们可以推出上一轮次中这个num的下标，然后根据上一轮num的下标推断出上上一轮num的下标，
//    直到推断出元素个数为n的那一轮num的下标，那我们就可以根据这个下标获取到最终的元素了。推断过程如下：
//
//    首先最后一轮中num的下标一定是0， 这个是已知的。
//    那上一轮应该是有两个元素，此轮次中 num 的下标为 (0 + m)%n = (0+3)%2 = 1; 说明这一轮删除之前num的下标为1；
//    再上一轮应该有3个元素，此轮次中 num 的下标为 (1+3)%3 = 1；说明这一轮某元素被删除之前num的下标为1；
//    再上一轮应该有4个元素，此轮次中 num 的下标为 (1+3)%4 = 0；说明这一轮某元素被删除之前num的下标为0；
//    再上一轮应该有5个元素，此轮次中 num 的下标为 (0+3)%5 = 3；说明这一轮某元素被删除之前num的下标为3；
//            ....
//
//    因为我们要删除的序列为0-n-1, 所以求得下标其实就是求得了最终的结果。比如当n 为5的时候，num的初始下标为3，
//    所以num就是3，也就是说从0-n-1的序列中， 经过n-1轮的淘汰，3这个元素最终存活下来了，也是最终的结果。
//
//    总结一下推导公式：(此轮过后的num下标 + m) % 上轮元素个数 = 上轮num的下标
//    f(n) = (f(n - 1) + m) % n
//    初始：f(1) = 0 只有一个元素时，剩余元素的下标肯定为0
    public int lastRemaining(int n, int m) {

        int pos = 0;
        System.out.println(pos);
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i;
            System.out.println(pos);
        }

        return pos;
    }

}

