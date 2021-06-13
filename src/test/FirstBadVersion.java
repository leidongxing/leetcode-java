package test;

interface VersionControl {
    boolean isBadVersion(int version);
}

/**
 * 第一个错误的版本
 */
public class FirstBadVersion implements VersionControl {
    public int firstBadVersion(int n) {
//    	for (int i = 1; i < n; i++) {
//            if (isBadVersion(i)) {
//                return i;
//            }
//        }
//        return n;

        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    @Override
    public boolean isBadVersion(int version) {
        // TODO Auto-generated method stub
        return false;
    }
}
