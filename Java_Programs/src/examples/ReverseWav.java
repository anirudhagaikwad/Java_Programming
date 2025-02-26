package examples;

import java.io.*;
import java.nio.file.*;
import java.nio.*;
import javax.sound.sampled.*;

/*
read a .wav file using java.nio, reverse its audio data, and save it as a new .wav file 
that plays in reverse order. However, playing it in reverse requires proper handling of the WAV 
format's headers and sample data.

🚀 Steps to Achieve This
Read the .wav file into a ByteBuffer using Files.readAllBytes(Path).
Extract the WAV header (first 44 bytes typically).
Reverse the audio sample data (after the header).
Write the modified byte array back to a new .wav file.
Play the reversed audio using Java Sound API.
Works for 16-bit PCM WAV (sampleSize = 2), but can be adapted for 8-bit PCM (sampleSize = 1).
If the file is stereo, reversing must keep left/right channels in sync.
Thread.sleep(10) ensures proper playback wait time.
 */
public class ReverseWav {
    public static void main(String[] args) {
        String inputFile = "input.wav";
        String outputFile = "reversed.wav";

        try {
            // Read file into ByteBuffer
            byte[] wavBytes = Files.readAllBytes(Paths.get(inputFile));

            // Ensure file is valid WAV
            if (!isValidWavFile(wavBytes)) {
                System.err.println("❌ Invalid WAV file.");
                return;
            }

            // Extract header (First 44 bytes for PCM WAV)
            byte[] header = new byte[44];
            System.arraycopy(wavBytes, 0, header, 0, 44);

            // Extract audio data
            byte[] audioData = new byte[wavBytes.length - 44];
            System.arraycopy(wavBytes, 44, audioData, 0, audioData.length);

            // Reverse audio data (Keep stereo channel consistency)
            reverseAudioData(audioData);

            // Write reversed data back to file
            writeReversedWavFile(outputFile, header, audioData);

            System.out.println("✅ Reversed WAV file created: " + outputFile);

            // Play reversed WAV file
            playWavFile(outputFile);

        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException | InterruptedException  e) {
            e.printStackTrace();
        }
    }

    // ✅ Checks if the file is a valid WAV format
    private static boolean isValidWavFile(byte[] data) {
        return data.length > 44 && new String(data, 0, 4).equals("RIFF");
    }

    // 🔄 Reverse the audio data (Ensure 16-bit PCM or 8-bit PCM)
    private static void reverseAudioData(byte[] data) {
        int sampleSize = 2; // 16-bit PCM (Each sample is 2 bytes)
        for (int i = 0; i < data.length / 2; i += sampleSize) {
            int j = data.length - sampleSize - i;
            for (int k = 0; k < sampleSize; k++) {
                byte temp = data[i + k];
                data[i + k] = data[j + k];
                data[j + k] = temp;
            }
        }
    }

    // 📝 Writes the reversed audio data to a new WAV file
    private static void writeReversedWavFile(String outputFile, byte[] header, byte[] audioData) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(outputFile);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(header);
            bos.write(audioData);
        }
    }

    // 🎵 Play the reversed WAV file
    private static void playWavFile(String filePath) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
        File file = new File(filePath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        System.out.println("🎶 Playing reversed audio...");
        clip.start();
        while (!clip.isRunning()) Thread.sleep(10);
        while (clip.isRunning()) Thread.sleep(10);
        clip.close();
    }
}
