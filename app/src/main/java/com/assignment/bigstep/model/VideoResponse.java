
package com.assignment.bigstep.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoResponse implements Parcelable
{

    @SerializedName("resultCount")
    @Expose
    private Integer resultCount;
    @SerializedName("results")
    @Expose
    private List<Video> music = null;
    public final static Creator<VideoResponse> CREATOR = new Creator<VideoResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public VideoResponse createFromParcel(Parcel in) {
            return new VideoResponse(in);
        }

        public VideoResponse[] newArray(int size) {
            return (new VideoResponse[size]);
        }

    }
    ;

    protected VideoResponse(Parcel in) {
        this.resultCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.music, (Video.class.getClassLoader()));
    }

    public VideoResponse() {
    }

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public List<Video> getMusic() {
        return music;
    }

    public void setMusic(List<Video> music) {
        this.music = music;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(resultCount);
        dest.writeList(music);
    }

    public int describeContents() {
        return  0;
    }

}
