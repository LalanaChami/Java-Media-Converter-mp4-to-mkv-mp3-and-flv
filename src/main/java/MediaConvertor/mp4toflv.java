package MediaConvertor;

import ws.schild.jave.*;

import java.io.File;

//tharindu's path:"D:\\converter\\media\\mp4toflv\\cinno.mp4"    "D:\\converter\\mediaConverted\\mp4convertedflv\\cinno.flv"
//nalaka's path: "C:\\Users\\Pc\\Desktop\\converter\\media\\mp4toflv\\01.mp4"  "C:\\Users\\Pc\\Desktop\\converter\\mediaconverter\\01.flv"
//lalana's path: "/Users/admin/Documents/mediaConvertor/media/mp4Toflv/1.mp4"  "/Users/admin/Documents/mediaConvertor/mediaConverted/mp4Toflv-converted/1.flv"

public class mp4toflv extends MediaEncoder{

    public void encode( String filename){
        try {
            File source = new File("/Users/admin/Documents/mediaConvertor/media/mp4Toflv/"+filename);
            File target = new File("/Users/admin/Documents/mediaConvertor/mediaConverted/mp4Toflv-converted/"+filename+".flv");

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
