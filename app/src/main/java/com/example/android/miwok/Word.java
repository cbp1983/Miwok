package com.example.android.miwok;
/**
* {@link Word} represents a vocabulary word that the user wants to learn.
* It contains a default translation and a Miwok translation and an image for that word.
*/

public class Word {

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    /** Image associated with the word */

    private int mImageResourceID = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Sound file associated with the word */

    private int mAudioResourceID;


    /**
    * Create a new Word object.
    *
    * @param defaultTranslation is the word in a language that the user is already familiar with
    *                           (such as English)
    * @param miwokTranslation is the word in the Miwok language
     *
     *                        @param audioResourceID is the sound file for the word
    */

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceID = audioResourceID;
        }

    /**
     * Second constructor in case of images available
     * @param defaultTranslation
     * @param miwokTranslation
     * @param getImageResourceID
     * @param audioResourceID
     */

    public Word(String defaultTranslation, String miwokTranslation, int getImageResourceID, int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = getImageResourceID;
        mAudioResourceID = audioResourceID;
    }

    /**
    * Get the default translation of the word.
    */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
    * Get the Miwok translation of the word.
    */

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get the sound asset for the word.
     */

    public int getAudioResourceID(){
        return mAudioResourceID;
    }

    /**
     * Get the image resource for this word.
     */

    public int getImageResourceID() { return mImageResourceID; }

    /**
     +     * Returns whether or not there is an image for this word.
     +     */
    public boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;
        }
}