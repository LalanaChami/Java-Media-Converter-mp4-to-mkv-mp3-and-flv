package MediaConvertor;

import ws.schild.jave.AudioAttributes;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.MultimediaObject;

import java.io.File;

public class mp4TOmp3 {
    public void encode(){
        try {
            File source = new File("C:\\Users\\Pc\\Desktop\\converter\\media\\mp4tomp3\\01.mp4");
            File target = new File("C:\\Users\\Pc\\Desktop\\converter\\mediaconverter\\01.mp3");

            //Audio Attributes
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(128000);
            audio.setChannels(2);
            audio.setSamplingRate(44100);

            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat("mp3");
            attrs.setAudioAttributes(audio);

            //Encode
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);

        } catch (Exception ex) {
            //ex.printStackTrace();
            boolean succeeded = false;
        }

    }
}
