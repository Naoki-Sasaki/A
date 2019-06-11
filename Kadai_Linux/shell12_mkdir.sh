for i in `seq 1 23`
do 
    if [ $i -lt 10 ] 
    then
        echo test0$i
    else
        echo test$i
    fi

done