package net.minecraftforge.common.util;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.util.Collections;
import java.util.Map;

public class FileSystemUtils
{
    /**
     * Finds an existing file system for the URI, or creates one.
     * Use this instead of directly calling FileSystems.newFileSystem since it may throw FileSystemExistsException.
     */
    public static FileSystem getOrNewFileSystem(URI uri, Map<String, ?> env) throws IOException
    {
        try
        {
            FileSystem fs = FileSystems.getFileSystem(uri);
            if (fs.isOpen())
                return fs;
        }
        catch (FileSystemNotFoundException ignored) {}

        return FileSystems.newFileSystem(uri, Collections.emptyMap());
    }
}
