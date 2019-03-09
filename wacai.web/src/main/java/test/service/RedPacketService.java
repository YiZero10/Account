package test.service;

/**
 * 接口内的方法不需要去实现 即 花括号
 */
public interface RedPacketService {
    public void send(String fromUserKey, String toUserKey, int number);

}
