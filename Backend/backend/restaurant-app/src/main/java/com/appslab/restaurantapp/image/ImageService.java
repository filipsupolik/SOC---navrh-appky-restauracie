package com.appslab.restaurantapp.image;

public interface ImageService {

    byte[] compressBytes(byte[] data);
    byte[] decompressBytes(byte[] data);

}
