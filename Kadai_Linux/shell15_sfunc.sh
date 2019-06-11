sfunc1(){
    if[ $1 = "a" ]
        then ls -l -a
    else if [$1 = "r" ]
        then ls -l -r
    else if [ $1 = "lar" -o $1 = "ral" ]
        then ls -l -a -ra
    else ls -l
    fi
}