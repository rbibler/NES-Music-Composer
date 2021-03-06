package com.bibler.awesome.nesmusiccomposer.audio;

public class TriangleWaveGenerator extends WaveGenerator {
	
	
	private int currentTimer;
	private int currentStep;
	private int currentVolume;
	private int[] sequence = new int[] {
		15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0,
		0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
	};
	
	private float channelVolume = 1.0f;
	
	private boolean mute;
	
	@Override
	public void updateVolume(float channelVolume) {
		this.channelVolume = channelVolume;
	}
	
	@Override
	public void mute(boolean mute) {
		this.mute = mute;
	}
	
	@Override
	public void reset() {
		lengthCounter = 0;
		currentTimer = 0;
		timer = 0;
		currentStep = 0;
		currentVolume = 0;
	}
	
	@Override
	public int clock() {
		if(currentTimer == 0) {
			currentTimer = timer;
			currentStep--;
			if(currentStep < 0) {
				currentStep = sequence.length - 1;
			}	
		} else {
			currentTimer--;
		}
		return 0;
	}
	
	@Override
	public void setPeriod(int timer) {
		this.timer = timer;
	}
	
	@Override
	public int getSample() {
		currentVolume =  sequence[currentStep];
		if(timer < 2) {
			currentVolume = 0;
		}
		return (int) (currentVolume * (mute ? 0 : 1) * channelVolume);
	}
	
}
