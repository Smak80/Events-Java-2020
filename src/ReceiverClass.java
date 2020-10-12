public class ReceiverClass implements ProgressListener, ResultListener{

    public void print(){
        var e = new EventClass(10);
        e.addProgressListener(new ProgressListener() {
            @Override
            public void showProgress(int s, int i) {
                ReceiverClass.this.showProgress(s, i);
                if (i>=5) e.removeProgressListener(this);
            }
        });
        e.addResultListener(this);
        e.calc();
    }

    public void showProgress(int s, int i){
        System.out.println(
                "Промежуточная сумма на шаге "+i+"="+s
        );
    }

    public void showResult(int s){
        System.out.println("Окончательный результат="+s);
    }
}
