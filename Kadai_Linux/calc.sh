
if [ "$1" = "+" ];
    then 
        num1=$(($2+$3));
        echo $num1
    elif [ "$1" = "-" ];
    then 
        num2=$(($2-$3));
        echo $num2
    elif [ "$1" = "/" ];
    then 
        num4=$(($2/$3));
        echo $num4
    else 
        num3=$(($2*$3));
        echo $num3
fi