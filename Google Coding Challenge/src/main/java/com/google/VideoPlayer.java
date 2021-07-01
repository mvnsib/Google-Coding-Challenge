package com.google;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private String currentVideoID = "";
  boolean pause = false;


  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    String[] arr = new String[videoLibrary.getVideos().size()];

    System.out.println("Here's a list of all available videos:");
    for (int i = 0; i < videoLibrary.getVideos().size(); i++){
      arr[i] = videoLibrary.getVideos().get(i).getTitle() + " (" +
              videoLibrary.getVideos().get(i).getVideoId() + ") " +
              videoLibrary.getVideos().get(i).getTags().toString().replaceAll(",", "");
      if(i == videoLibrary.getVideos().size()-1){
        Arrays.sort(arr);
        for(int j = 0; j < arr.length; j++){
          System.out.println(arr[j]);
        }
        break;
      }
    }
  }
  public void playVideo(String videoId) {
    boolean doesExist = false;
    String videoTitle = "";
    String currentVideo = "";

    for(int i = 0; i < videoLibrary.getVideos().size(); i++){
      if(videoLibrary.getVideos().get(i).getVideoId().contains(videoId)){
        doesExist = true;
        videoTitle = videoLibrary.getVideo(videoId).getTitle();
        currentVideo = videoLibrary.getVideo(videoId).getVideoId();
        break;
      }
    }
    if(doesExist == true){
      System.out.println("Playing video: " + videoTitle);
      currentVideoID = currentVideo;
    }else{
      System.out.println("Cannot play video: Video does not exist");
    }
  }

  public void stopVideo() {

    if(currentVideoID != ""){
      System.out.println("Stopping video: " + videoLibrary.getVideo(currentVideoID).getTitle());
      currentVideoID = "";
    }else{
      System.out.println("Cannot stop video: No video is currently playing");
    }
  }

  public void playRandomVideo() {
    Random r = new Random();
    String videoTitle = "";

    int randomNum = r.nextInt((videoLibrary.getVideos().size() - 1));
    videoTitle = videoLibrary.getVideos().get(randomNum).getTitle();
    System.out.println("Playing video: " + videoTitle);
  }

  public void pauseVideo() {
    if(currentVideoID == ""){
      System.out.println("Cannot pause video: No video is currently playing");
    }
    else if(currentVideoID != "" && pause == false) {
      System.out.println("Pausing video: " + videoLibrary.getVideo(currentVideoID).getTitle());
      pause = true;
    }else{
      System.out.println("Video already paused: " + videoLibrary.getVideo(currentVideoID).getTitle());
    }
  }

  public void continueVideo() {

    if(currentVideoID != "" && pause){
      System.out.println("Continuing video: " + videoLibrary.getVideo(currentVideoID).getTitle());
    }else if (currentVideoID != "" && !pause){
      System.out.println("Cannot continue video: Video is not paused");
    }
    else{
      System.out.println("Cannot continue video: No video is currently playing");
    }
  }

  public void showPlaying() {//
    if(currentVideoID != "" && !pause){
      System.out.println("Currently playing: " + videoLibrary.getVideo(currentVideoID).getTitle() + " (" + currentVideoID + ") " + videoLibrary.getVideo(currentVideoID).getTags().toString().replaceAll(",",""));
    }else if(currentVideoID != "" && pause){
      System.out.println("Currently playing: " + videoLibrary.getVideo(currentVideoID).getTitle() + " (" + currentVideoID + ") " + videoLibrary.getVideo(currentVideoID).getTags().toString().replaceAll(",","") + " - PAUSED");
    }
    else{
      System.out.println("No video is currently playing");
    }
  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}