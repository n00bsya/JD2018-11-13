package by.it.markelov.calc;

class Scalar extends Var {
    double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str) {
        value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar) {
        value = scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double result = this.value + operand2.value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double result = this.value - operand2.value;
            return new Scalar(result);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double result = this.value * operand2.value;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            if (operand2.value == 0)
                throw new CalcExeption("Деление на ноль");
            double result = this.value / operand2.value;
            return new Scalar(result);
        }
        throw new CalcExeption("Деление числа на вектор или матрицу невозможно");
    }
}
