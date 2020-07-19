package MediaConvertor;

import ws.schild.jave.AudioAttributes;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.MultimediaObject;

import java.io.File;

//tharindu's path:"D:\\converter\\media\\mp4tomp3\\cinno.mp4"    "D:\\converter\\mediaConverted\\mp4convertedmp3\\cinno.mp3"
//nalaka's path: "C:\\Users\\Pc\\Desktop\\converter\\media\\mp4tomp3\\01.mp4"  "C:\\Users\\Pc\\Desktop\\converter\\mediaconverter\\01.mp3"
//lalana's path: "/Users/admin/Documents/mediaConvertor/media/mp4Tomp3/1.mp4"  "/Users/admin/Documents/mediaConvertor/mediaConverted/mp4Tomp3-converted/1.mp3"


public class mp4TOmp3 extends MediaEncoder{
    public void encode(String filename){
        try {
            File source = new File("/Users/admin/Documents/mediaConvertor/media/mp4Tomp3/"+filename);
            File target = new File("/Users/admin/Documents/mediaConvertor/mediaConverted/mp4Tomp3-converted/"+filename+".mp3");

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
