#include "system.hpp"

#include <boost/date_time/posix_time/posix_time.hpp>

using namespace com::uosipa::chatuvolchat;
using std::string;

string system::get_current_time()
{
    boost::posix_time::ptime time = boost::posix_time::second_clock::local_time();
    char result[64];
    sprintf_s(result, "%04d-%02d-%02d %02d:%02d:%02d",
        (int)time.date().year(), (int)time.date().month(), (int)time.date().day(),
        (int)time.time_of_day().hours(), (int)time.time_of_day().minutes(),
        (int)time.time_of_day().seconds()
    );

    return (string)(result);
}
