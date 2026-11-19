package org.example.bl;

import org.example.media.Media;

import java.util.ArrayList;
import java.util.List;

public class BL
{
    public List<Media> filterBy(String target, List<Media> token)
    {
        List<Media> list = new ArrayList<>();

        System.out.println("BL.filterBy(" + target + ")");
        switch (target)
        {
            case "all":
                return token;

            case "books":
            case "games":
            case "movies":
                for(Media m : token)
                {
                    if(m.getClass().equals(target))
                        list.add(m);
                }

                break;
        }
    }
}
