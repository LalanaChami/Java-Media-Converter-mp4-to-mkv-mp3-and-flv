package MediaConvertor;

import ws.schild.jave.*;

import java.io.File;

public class mp4toflv {

    public void encode(){
        try {
            File source = new File("D:\\converter\\media\\mp4toflv\\cinno.mp4");
            File target = new File("D:\\converter\\mediaConverted\\mp4convertedflv\\cinno.flv");

            //Audio Attributes
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(new Integer(64000));
            audio.setChannels(new Integer(1));
            audio.setSamplingRate(new Integer(22050));

            //video Attributes
            VideoAttributes video = new VideoAttributes();
            video.setCodec("flv");
            video.setBitRate(new Integer(160000));
            video.setFrameRate(new Integer(15));
            video.setSize(new VideoSize(400, 300));

            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat("flv");
            attrs.setAudioAttributes(audio);
            attrs.setVideoAttributes(video);

            //Encode
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);

        } catch (Exception ex) {
            //ex.printStackTrace();
            boolean succeeded = false;
        }

    }





}
