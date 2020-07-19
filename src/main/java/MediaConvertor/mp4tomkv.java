package MediaConvertor;

import ws.schild.jave.*;

import java.io.File;

//tharindu's path:"D:\\converter\\media\\mp4tomkv\\cinno.mp4"    "D:\\converter\\mediaConverted\\mp4convertedmkv\\cinno.mkv"
//nalaka's path: "C:\\Users\\Pc\\Desktop\\converter\\media\\mp4tomkv\\01.mp4"  "C:\\Users\\Pc\\Desktop\\converter\\mediaconverter\\01.mkv"
//lalana's path: "/Users/admin/Documents/mediaConvertor/media/mp4Tomkv/1.mp4"  "/Users/admin/Documents/mediaConvertor/mediaConverted/mp4Tomkv-converted/1.mkv"

public class mp4tomkv extends MediaEncoder {

    public void encode(String filename){
        try {
            File source = new File("/Users/admin/Documents/mediaConvertor/media/mp4Tomkv/"+filename);
            File target = new File("/Users/admin/Documents/mediaConvertor/mediaConverted/mp4Tomkv-converted/"+filename+".mkv");

            //Audio Attributes
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(new Integer(64000));
            audio.setChannels(new Integer(1));
            audio.setSamplingRate(new Integer(22050));

            //video Attributes
            VideoAttributes video = new VideoAttributes();
            video.setCodec("mpeg4");
            video.setBitRate(new Integer(160000));
            video.setFrameRate(new Integer(15));
            video.setSize(new VideoSize(400, 300));

            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat("matroska");
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

