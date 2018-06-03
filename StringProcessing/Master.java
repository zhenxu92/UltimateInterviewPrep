    public class Master {
        private String ans;
        public Master(String s) {
            this.ans = s;
        }
        
        public boolean guess(String s) {
            return s.equals(ans);
        }
    }