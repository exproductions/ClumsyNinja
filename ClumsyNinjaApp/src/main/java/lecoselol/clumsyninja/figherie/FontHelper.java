/*
 * Copyright 2013 Sebastiano Poggi and Francesco Pontillo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package lecoselol.clumsyninja.figherie;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * Helps retrieving and loading custom fonts from the app assets.
 *
 * @author Sebastiano Poggi
 */
public class FontHelper {

    private static final HashMap<String, Typeface> mFontsCache = new HashMap<String, Typeface>();

    /**
     * Gets DAT TYPEFACE.
     *
     * @param ctx The context to load the font with, if needed.
     *
     * @return Returns the Typeface, or null if it's not been loaded
     *         yet and ctx is null.
     */
    public static Typeface getElFontDelSenhorCardo(Context ctx) {
        return getFont(ctx, "senhor_fonto.ttf");
    }

    /**
     * Gets an instance of the specified Typeface.
     *
     * @param ctx      The context to load the font with, if needed.
     * @param fontName The name of the font (the name of the TTF file in the /res/assets dir)
     *
     * @return Returns the Typeface, or null if it's not been loaded
     *         yet and ctx is null.
     */
    public static Typeface getFont(Context ctx, String fontName) {
        Typeface font;
        if (!isFontCached(fontName)) {
            if (ctx == null) {
                return null;   // We can't retrieve it...
            }

            font = Typeface.createFromAsset(ctx.getAssets(), fontName);
            if (font != null) {
                // Cache it if we've successfully loaded it
                mFontsCache.put(fontName, font);
            }
        }
        else {
            font = mFontsCache.get(fontName);
        }

        return font;
    }

    /**
     * Gets a value indicating if the specified font is already in the font cache.
     *
     * @param fontName The name of the font (the name of the TTF file in the /res/assets dir)
     *
     * @return Returns true if the font is in the cache, else false.
     */
    public static boolean isFontCached(String fontName) {
        for (String name : mFontsCache.keySet()) {
            if (name.equals(fontName)) {
                return true;
            }
        }
        return false;
    }
}