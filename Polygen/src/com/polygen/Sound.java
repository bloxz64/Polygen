package com.polygen;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * A file to help make the loading and playing of audio systems more simple.
 * @author Owen Anderson, Christopher Lapena
 */

public class Sound {
	
	public Clip sound;

	/**
	 * creates object using the path of the sounds as a string
	 * @param path the path to the sound
	 */
	public Sound(String path){
		try {
			sound = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(path));
			sound.open(ais);
		} catch (LineUnavailableException e) {
			System.out.println("Error with audio system.");
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			System.out.println("Audio format not supported.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File could not be loaded.");
			e.printStackTrace();
		}
	}
	
	/**
	 * creates the object using a URL as the sound loading method
	 * @param url the URL to the sound file
	 */
	public Sound(URL url){
		try {
			sound = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(url);
			sound.open(ais);
		} catch (LineUnavailableException e) {
			System.out.println("Error with audio system.");
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			System.out.println("Audio format not supported");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File could not be loaded");
			e.printStackTrace();
		}
	}
	
	/**
	 * starts to play the audio file
	 */
	public void play(){
		sound.start();
	}
	
	/**
	 * stops the sound from playing
	 */
	public void stop(){
		sound.stop();
	}
	
	/**
	 * plays the audio for a given number of loops -1 for forever
	 * @param loops
	 */
	public void loop(int loops){
		sound.loop(loops);
	}
}
