#include <iostream>

int main() 
{
    // The const keyword specifies that a variable's value is constant
    // tells the compiler to prevent anything from modifying.it
    // ( read - only )
    const double PI = 3.14159; //constants are like static
    double radius = 10;
    double circumference = 2 * 2 * PI * radius;
    std :: cout << circumference << " cm ";
    return 0;
}
