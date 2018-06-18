package com.lemuel.lemubit.nyscpack.model;

/**
 *
 * @author lemuel
 */
public class HomeMenuItems {
    private String lottieAnimation;
    private String description;

    public HomeMenuItems(String lottieAnimation, String description) {
        this.lottieAnimation = lottieAnimation;
        this.description = description;
    }

    public String getLottieAnimation() {
        return lottieAnimation;
    }

    public String getDescription() {
        return description;
    }
}
