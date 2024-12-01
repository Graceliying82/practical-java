package org.graceliying.leetcode;

import lombok.extern.slf4j.Slf4j;

/*Given an m x n picture consisting of black 'B' and white 'W' pixels, return the number of black lonely pixels.

A black lonely pixel is a character 'B' that located at a specific position where the same row and same column don't have any other black pixels.
 */
public class LonelyPixel531 {

    public static int findLonelyPixel(char[][] picture) {
        int n = picture.length;
        int m = picture[0].length;
        int lonelyCount = 0;

        int rowCount[] = new int[n];
        int colCount[] = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] ==1) {
                    lonelyCount++;
                }
            }
        }

        return lonelyCount;
    }
}
