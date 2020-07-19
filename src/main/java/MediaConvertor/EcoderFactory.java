package MediaConvertor;

public class EcoderFactory {
    public MediaEncoder getInstence(String codecType){

        if("mp3".equals(codecType)){
            return new mp4TOmp3();
        }
        if("mkv".equals(codecType)){
            return new mp4tomkv();
        }
        if("flv".equals(codecType)){
            return new mp4toflv();
        }
        return null;
    }
}
