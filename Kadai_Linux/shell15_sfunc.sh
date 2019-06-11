sfunc1(){
    if[ $1 = "a" ]
        then ls -l -a
    else if [$1 = "r" ]
        then ls -l -r
    else if [ $1 = "lr" -o $1 = "rl" ]
        then ls -l -a -ra
    else ls -l
    fi
}