package com.siwoo.types;

public class ScopeTest {
    
    private static class Scope {
        private int e = 2;
        
        public void showElement(int param) {
            assert param >= 0;
            if (param == 0) return;
            System.out.printf("Guess what is the scope of param [%d]%n", param);
            int e = 1;
            System.out.println("Method Level scope: " + e);
            System.out.println("Class Level scope: " + this.e);
            
            Scope outerScope = new Scope();
            {
                Scope blockScope = new Scope();
                blockScope.showElement(param-1);
            }
            outerScope.showElement(param-1);
            //blockScope.showElement();
            
            for (int i=0; i<10; i++) {
                System.out.println(i << 1);
            }
            //System.out.println(i << 1);
        }
    }

    public static void main(String[] args) {
        new Scope().showElement(10);
    }
}
