package de.aderenbach.vertxspringbootexample;


import de.aderenbach.vertxspringbootexample.model.User;
import io.netty.util.CharsetUtil;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;
import io.vertx.core.json.Json;

/**
 * Created by kinggrass on 01.07.15.
 */
public class UserMessageCodec implements MessageCodec<User,User>{

    @Override
    public void encodeToWire(Buffer buffer, User user) {
        String strJson = Json.encode(user);
        byte[] encoded = strJson.getBytes(CharsetUtil.UTF_8);
        buffer.appendInt(encoded.length);
        Buffer buff = Buffer.buffer(encoded);
        buffer.appendBuffer(buff);
    }

    @Override
    public User decodeFromWire(int pos, Buffer buffer) {
        int length = buffer.getInt(pos);
        pos += 4;
        byte[] encoded = buffer.getBytes(pos, pos + length);
        String str = new String(encoded, CharsetUtil.UTF_8);
        return Json.decodeValue(str,User.class);
    }

    @Override
    public User transform(User user) {
        return user; // as long as User is immutable this is fine ;)
    }

    @Override
    public String name() {
        return "user";
    }

    @Override
    public byte systemCodecID() {
        return -1;
    }
}
