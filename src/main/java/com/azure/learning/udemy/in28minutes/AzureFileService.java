package com.azure.learning.udemy.in28minutes;

import com.azure.storage.file.share.ShareClient;
import com.azure.storage.file.share.ShareClientBuilder;

public class AzureFileService {


    public static final String connectStr =
            "DefaultEndpointsProtocol=https;AccountName=rakeshyedlapallistorage;" +
                    "AccountKey=dkQV74XztgIm7sWSiACat1XATtyiHyXFv5Hui1UkybqOmiqKEbU26FaV/gXuoslWWoKuhNtoq2pu+AStLmVOAw==;" +
                    "EndpointSuffix=core.windows.net";

    public static void main(String[] args) {
        create();
//delete();

    }

    public static void delete() {
        boolean isCreated = deleteFileShare(connectStr,"my-file-storage");

        if (isCreated) {
            System.out.println("The file is Deleted");
        } else {
            System.out.println("The file could not be Deleted");
        }
    }

    private static void create() {
        boolean isCreated = createFileShare(connectStr, "javaprogramsharedname");
        if (isCreated) {
            System.out.println("The file is created");
        } else {
            System.out.println("The file could not be created");
        }
    }

    public static Boolean createFileShare(String connectStr, String shareName) {
        try {
            ShareClient shareClient = new ShareClientBuilder()
                    .connectionString(connectStr).shareName(shareName)
                    .buildClient();

            shareClient.create();
            return true;
        } catch (Exception e) {
            System.out.println("createFileShare exception: " + e.getMessage());
            return false;
        }
    }

    public static Boolean deleteFileShare(String connectStr, String shareName)
    {
        try
        {
            ShareClient shareClient = new ShareClientBuilder()
                    .connectionString(connectStr).shareName(shareName)
                    .buildClient();

            shareClient.delete();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("deleteFileShare exception: " + e.getMessage());
            return false;
        }
    }
}
